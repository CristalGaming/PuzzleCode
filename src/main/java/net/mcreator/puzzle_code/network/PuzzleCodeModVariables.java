package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PuzzleCodeModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		PuzzleCodeMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			if (!event.isWasDeath()) {
				clone.IsSwitchedYellow = original.IsSwitchedYellow;
				clone.YellowSwitcherEffectPower = original.YellowSwitcherEffectPower;
				clone.positionSetXPos = original.positionSetXPos;
				clone.positionSetYPos = original.positionSetYPos;
				clone.positionSetZPos = original.positionSetZPos;
				clone.positionSetXPos2 = original.positionSetXPos2;
				clone.positionSetYPos2 = original.positionSetYPos2;
				clone.positionSetZPos2 = original.positionSetZPos2;
				clone.NBTVerifierNBT = original.NBTVerifierNBT;
				clone.NBTVerifierCurrentValue = original.NBTVerifierCurrentValue;
				clone.NBTVerifierVariableType = original.NBTVerifierVariableType;
				clone.NBTVerifierXPosBlock = original.NBTVerifierXPosBlock;
				clone.NBTVerifierYPosBlock = original.NBTVerifierYPosBlock;
				clone.NBTVerifierZPosBlock = original.NBTVerifierZPosBlock;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PuzzleCodeMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PuzzleCodeMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PuzzleCodeMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "puzzle_code_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				PuzzleCodeMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "puzzle_code_mapvars";
		public boolean IsSwitchedBlue = false;
		public boolean IsTimedSwitched = false;
		public BlockState ABlockIsBrokenBlockstate = Blocks.AIR.defaultBlockState();
		public double ABlockIsBrokenX_Pos = 0.0;
		public double ABlockIsBrokenY_Pos = 0.0;
		public double ABlockIsBrokenZ_Pos = 0.0;
		public BlockState ABlockIsPlacedBlockstate = Blocks.AIR.defaultBlockState();
		public double ABlockIsPlacedX_Pos = 0;
		public double ABlockIsPlacedY_Pos = 0;
		public double ABlockIsPlacedZ_Pos = 0.0;
		public double TimedSwitchingTime = 0.0;
		public double ABlockIsRightClickedX_Pos = 0.0;
		public double ABlockIsRightClickedY_Pos = 0.0;
		public double ABlockIsRightClickedZ_Pos = 0.0;
		public BlockState ABlockIsRightClickedBlockstate = Blocks.AIR.defaultBlockState();
		public double ABlockIsLeftClickedX_Pos = 0.0;
		public double ABlockIsLeftClickedY_Pos = 0;
		public double ABlockIsLeftClickedZ_Pos = 0;
		public BlockState ABlockIsLeftClickedBlockstate = Blocks.AIR.defaultBlockState();

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			IsSwitchedBlue = nbt.getBoolean("IsSwitchedBlue");
			IsTimedSwitched = nbt.getBoolean("IsTimedSwitched");
			ABlockIsBrokenBlockstate = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), nbt.getCompound("ABlockIsBrokenBlockstate"));
			ABlockIsBrokenX_Pos = nbt.getDouble("ABlockIsBrokenX_Pos");
			ABlockIsBrokenY_Pos = nbt.getDouble("ABlockIsBrokenY_Pos");
			ABlockIsBrokenZ_Pos = nbt.getDouble("ABlockIsBrokenZ_Pos");
			ABlockIsPlacedBlockstate = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), nbt.getCompound("ABlockIsPlacedBlockstate"));
			ABlockIsPlacedX_Pos = nbt.getDouble("ABlockIsPlacedX_Pos");
			ABlockIsPlacedY_Pos = nbt.getDouble("ABlockIsPlacedY_Pos");
			ABlockIsPlacedZ_Pos = nbt.getDouble("ABlockIsPlacedZ_Pos");
			TimedSwitchingTime = nbt.getDouble("TimedSwitchingTime");
			ABlockIsRightClickedX_Pos = nbt.getDouble("ABlockIsRightClickedX_Pos");
			ABlockIsRightClickedY_Pos = nbt.getDouble("ABlockIsRightClickedY_Pos");
			ABlockIsRightClickedZ_Pos = nbt.getDouble("ABlockIsRightClickedZ_Pos");
			ABlockIsRightClickedBlockstate = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), nbt.getCompound("ABlockIsRightClickedBlockstate"));
			ABlockIsLeftClickedX_Pos = nbt.getDouble("ABlockIsLeftClickedX_Pos");
			ABlockIsLeftClickedY_Pos = nbt.getDouble("ABlockIsLeftClickedY_Pos");
			ABlockIsLeftClickedZ_Pos = nbt.getDouble("ABlockIsLeftClickedZ_Pos");
			ABlockIsLeftClickedBlockstate = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), nbt.getCompound("ABlockIsLeftClickedBlockstate"));
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("IsSwitchedBlue", IsSwitchedBlue);
			nbt.putBoolean("IsTimedSwitched", IsTimedSwitched);
			nbt.put("ABlockIsBrokenBlockstate", NbtUtils.writeBlockState(ABlockIsBrokenBlockstate));
			nbt.putDouble("ABlockIsBrokenX_Pos", ABlockIsBrokenX_Pos);
			nbt.putDouble("ABlockIsBrokenY_Pos", ABlockIsBrokenY_Pos);
			nbt.putDouble("ABlockIsBrokenZ_Pos", ABlockIsBrokenZ_Pos);
			nbt.put("ABlockIsPlacedBlockstate", NbtUtils.writeBlockState(ABlockIsPlacedBlockstate));
			nbt.putDouble("ABlockIsPlacedX_Pos", ABlockIsPlacedX_Pos);
			nbt.putDouble("ABlockIsPlacedY_Pos", ABlockIsPlacedY_Pos);
			nbt.putDouble("ABlockIsPlacedZ_Pos", ABlockIsPlacedZ_Pos);
			nbt.putDouble("TimedSwitchingTime", TimedSwitchingTime);
			nbt.putDouble("ABlockIsRightClickedX_Pos", ABlockIsRightClickedX_Pos);
			nbt.putDouble("ABlockIsRightClickedY_Pos", ABlockIsRightClickedY_Pos);
			nbt.putDouble("ABlockIsRightClickedZ_Pos", ABlockIsRightClickedZ_Pos);
			nbt.put("ABlockIsRightClickedBlockstate", NbtUtils.writeBlockState(ABlockIsRightClickedBlockstate));
			nbt.putDouble("ABlockIsLeftClickedX_Pos", ABlockIsLeftClickedX_Pos);
			nbt.putDouble("ABlockIsLeftClickedY_Pos", ABlockIsLeftClickedY_Pos);
			nbt.putDouble("ABlockIsLeftClickedZ_Pos", ABlockIsLeftClickedZ_Pos);
			nbt.put("ABlockIsLeftClickedBlockstate", NbtUtils.writeBlockState(ABlockIsLeftClickedBlockstate));
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PuzzleCodeMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("puzzle_code", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean IsSwitchedYellow = false;
		public double YellowSwitcherEffectPower = -1.0;
		public double positionSetXPos = 0;
		public double positionSetYPos = 0;
		public double positionSetZPos = 0;
		public double positionSetXPos2 = 0;
		public double positionSetYPos2 = 0;
		public double positionSetZPos2 = 0.0;
		public String NBTVerifierNBT = "none";
		public String NBTVerifierCurrentValue = "none";
		public String NBTVerifierVariableType = "Number";
		public double NBTVerifierXPosBlock = 0;
		public double NBTVerifierYPosBlock = 0;
		public double NBTVerifierZPosBlock = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PuzzleCodeMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("IsSwitchedYellow", IsSwitchedYellow);
			nbt.putDouble("YellowSwitcherEffectPower", YellowSwitcherEffectPower);
			nbt.putDouble("positionSetXPos", positionSetXPos);
			nbt.putDouble("positionSetYPos", positionSetYPos);
			nbt.putDouble("positionSetZPos", positionSetZPos);
			nbt.putDouble("positionSetXPos2", positionSetXPos2);
			nbt.putDouble("positionSetYPos2", positionSetYPos2);
			nbt.putDouble("positionSetZPos2", positionSetZPos2);
			nbt.putString("NBTVerifierNBT", NBTVerifierNBT);
			nbt.putString("NBTVerifierCurrentValue", NBTVerifierCurrentValue);
			nbt.putString("NBTVerifierVariableType", NBTVerifierVariableType);
			nbt.putDouble("NBTVerifierXPosBlock", NBTVerifierXPosBlock);
			nbt.putDouble("NBTVerifierYPosBlock", NBTVerifierYPosBlock);
			nbt.putDouble("NBTVerifierZPosBlock", NBTVerifierZPosBlock);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			IsSwitchedYellow = nbt.getBoolean("IsSwitchedYellow");
			YellowSwitcherEffectPower = nbt.getDouble("YellowSwitcherEffectPower");
			positionSetXPos = nbt.getDouble("positionSetXPos");
			positionSetYPos = nbt.getDouble("positionSetYPos");
			positionSetZPos = nbt.getDouble("positionSetZPos");
			positionSetXPos2 = nbt.getDouble("positionSetXPos2");
			positionSetYPos2 = nbt.getDouble("positionSetYPos2");
			positionSetZPos2 = nbt.getDouble("positionSetZPos2");
			NBTVerifierNBT = nbt.getString("NBTVerifierNBT");
			NBTVerifierCurrentValue = nbt.getString("NBTVerifierCurrentValue");
			NBTVerifierVariableType = nbt.getString("NBTVerifierVariableType");
			NBTVerifierXPosBlock = nbt.getDouble("NBTVerifierXPosBlock");
			NBTVerifierYPosBlock = nbt.getDouble("NBTVerifierYPosBlock");
			NBTVerifierZPosBlock = nbt.getDouble("NBTVerifierZPosBlock");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.IsSwitchedYellow = message.data.IsSwitchedYellow;
					variables.YellowSwitcherEffectPower = message.data.YellowSwitcherEffectPower;
					variables.positionSetXPos = message.data.positionSetXPos;
					variables.positionSetYPos = message.data.positionSetYPos;
					variables.positionSetZPos = message.data.positionSetZPos;
					variables.positionSetXPos2 = message.data.positionSetXPos2;
					variables.positionSetYPos2 = message.data.positionSetYPos2;
					variables.positionSetZPos2 = message.data.positionSetZPos2;
					variables.NBTVerifierNBT = message.data.NBTVerifierNBT;
					variables.NBTVerifierCurrentValue = message.data.NBTVerifierCurrentValue;
					variables.NBTVerifierVariableType = message.data.NBTVerifierVariableType;
					variables.NBTVerifierXPosBlock = message.data.NBTVerifierXPosBlock;
					variables.NBTVerifierYPosBlock = message.data.NBTVerifierYPosBlock;
					variables.NBTVerifierZPosBlock = message.data.NBTVerifierZPosBlock;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
