package jlcat.bstools.gui;

import jlcat.bstools.inventory.ContainerBag;
import jlcat.bstools.inventory.InventoryBag;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBag extends GuiContainer {

	private static final ResourceLocation BAGPACK_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
	private IInventory playerInventory;
	private IInventory bagpackInventory;
	private int inventoryRows;

	public GuiBag(InventoryPlayer inventoryPlayer, InventoryBag inventoryBag, EntityPlayer player) {
		super(new ContainerBag(inventoryPlayer, inventoryBag, Minecraft.getMinecraft().thePlayer));
		this.playerInventory = inventoryPlayer;
		this.bagpackInventory = inventoryBag;
		this.allowUserInput = false;
		int i = 222;
		int j = i - 108;
		this.inventoryRows = inventoryBag.getSizeInventory() / 9;
		this.ySize = j + this.inventoryRows * 18;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 * 
	 * @param mouseX
	 *            Mouse x coordinate
	 * @param mouseY
	 *            Mouse y coordinate
	 */
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRendererObj.drawString(this.bagpackInventory.getDisplayName().getUnformattedText(), 8, 6, 4210752);
		this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	 * Draws the background layer of this container (behind the items).
	 * 
	 * @param partialTicks
	 *            How far into the current tick the game is, with 0.0 being the
	 *            start of the tick and 1.0 being the end.
	 * @param mouseX
	 *            Mouse x coordinate
	 * @param mouseY
	 *            Mouse y coordinate
	 */
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(BAGPACK_GUI_TEXTURE);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
		this.drawTexturedModalRect(i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
	}
}
