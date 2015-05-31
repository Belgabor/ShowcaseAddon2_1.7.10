package defeatedcrow.showcase.plugin;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import shift.mceconomy2.api.MCEconomyAPI;
import shift.mceconomy2.api.shop.IProductItem;
import shift.mceconomy2.api.shop.ProductItem;
import shift.mceconomy2.api.shop.ProductList;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 冬のショップ。
 * 氷原のものを買うことができる。
 */
public class WinterShopList extends ProductList {

	private static ArrayList<IProductItem> thisProducts = new ArrayList<IProductItem>();
	public static int thisShopId = -1;

	public void load() {
		thisShopId = MCEconomyAPI.registerProductList(this);
		registerProducts();
	}

	@Override
	public String getProductListName() {

		return "Winter Shop";
	}

	static void registerProducts() {
		thisProducts.add(new ProductItem(new ItemStack(Blocks.sapling, 1, 1), 250));
		thisProducts.add(new ProductItem(new ItemStack(Blocks.packed_ice, 1, 5), 200));
		thisProducts.add(new ProductItem(new ItemStack(Blocks.snow, 1, 1), 100));
		thisProducts.add(new ProductItem(new ItemStack(Blocks.mycelium, 1, 0), 500));

		Item crop = GameRegistry.findItem("DCsAppleMilk", "defeatedcrow.leafTea");
		if (crop != null) {
			thisProducts.add(new ProductItem(new ItemStack(crop, 1, 4), 200));
		}
	}

	@Override
	public void addItemProduct(IProductItem item) {
		thisProducts.add(item);
	}

	@Override
	public int getItemProductSize() {
		return thisProducts.size();
	}

	@Override
	public ArrayList<IProductItem> getProductList() {
		return thisProducts;
	}
}
