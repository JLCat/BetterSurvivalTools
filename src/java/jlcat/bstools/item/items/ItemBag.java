package jlcat.bstools.item.items;

import java.util.List;

import jlcat.bstools.BSTools;
import jlcat.bstools.common.BSToolsTab;
import jlcat.bstools.gui.ModGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBag extends Item {

	private static final String name = "bag";
	private static final ItemBag instance = new ItemBag();

	private ItemBag() {
		super();
		setUnlocalizedName(name);
		setCreativeTab(BSToolsTab.TAB_BSTOOLS);
		setMaxStackSize(1);
		setRegistryName(new ResourceLocation(BSTools.MOD_ID, name));
		GameRegistry.register(this);
	}

	public static final ItemBag instance() {
		return instance;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return isBound(stack);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {

		if (!world.isRemote) {
			if (player.isSneaking() && !isBound(itemStack)) {
				NBTTagCompound nbtC = new NBTTagCompound();
				nbtC.setString("owner", player.getName());
				itemStack.setTagCompound(nbtC);
				return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStack);
			}

			if (isBound(itemStack)) {
				if (player.getName().equals(getOwner(itemStack))) {
					player.openGui(BSTools.instance, ModGuiHandler.GUI_BAG, world, 0, 0, 0);
				} else {
					player.addChatComponentMessage(new TextComponentString(TextFormatting.YELLOW.toString() + TextFormatting.BOLD.toString() + I18n.translateToLocal("msg.mod") + TextFormatting.WHITE.toString() + I18n.translateToLocal("msg.notyourbag")));
				}
				return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStack);
			} else {
				player.addChatComponentMessage(new TextComponentString(TextFormatting.YELLOW.toString() + TextFormatting.BOLD.toString() + I18n.translateToLocal("msg.mod") + TextFormatting.WHITE.toString() + I18n.translateToLocal("msg.notboundyet")));
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStack);
	}

	private boolean isBound(ItemStack stack) {
		return stack.hasTagCompound() && stack.getTagCompound().hasKey("owner");
	}

	private String getOwner(ItemStack stack) {
		return isBound(stack) ? stack.getTagCompound().getString("owner") : "";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		final String bound = TextFormatting.BLUE + I18n.translateToLocal("tooltip.owner") + ":" + getOwner(stack);
		final String unbound = TextFormatting.GRAY + I18n.translateToLocal("tooltip.unbound");
		tooltip.add(isBound(stack) ? bound : unbound);
	}
}
