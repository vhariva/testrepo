package controllers;

import java.util.List;

import models.Item;
import models.ItemFlavor;
import models.Testmap;
import play.mvc.*;

public class Testnav extends Application {

	@Secure
    public static void index(Long tmId, int itemIndex) {

        Testmap testmap = Testmap.findById(tmId);
        notFoundIfNull(testmap, "The Testmap with (Id="+tmId+") was not found.");

        int itemCount = testmap.testmapItems.size();
        if (itemCount == 0) {
        	notFound("Invalid Testmap.  No Items found.");
        } else if (itemIndex >= itemCount) {
        	notFound("Invalid Item Index.  No Items found.");
        }
        //commenting
        String testmapArrayString = "";
		for (int i=0; i < itemCount; i++) {
			if (i == 0) {
				testmapArrayString += testmap.testmapItems.get(i).item.id.toString();
			} else {
				testmapArrayString += "," + testmap.testmapItems.get(i).item.id.toString();
			}
		}
		testmapArrayString = "[" + testmapArrayString + "]";
		//Commenting
		Long itemId = testmap.testmapItems.get(itemIndex).item.id;
		Item item = Item.findById(itemId);
		notFoundIfNull(item, "Unable to find requested Item with (Id="+itemId+").");

		ItemFlavor itemFlavor = item.getItemFlavorByFlavor(1);//Commenting
        render(testmap, testmapArrayString, itemIndex, item, itemFlavor);
    }

}
