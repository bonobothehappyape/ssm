package gr.scram.wicket.img;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * Provider for image files.
 * @author asvesdi
 */
public class ImageProvider {
	
	/**
	 * static constant.
	 */
	private static final String LOGO_IMAGE_ID = "logo";
	
	/**
	 * logo icon.
	 */
	public static final Image LOGO = new Image(LOGO_IMAGE_ID,
			new PackageResourceReference(ImageProvider.class, "logo.png"));
	
	/**
	 * Get the image.
	 * @param filename - image filename.
	 * @return - the Image file.
	 */
	public static Image getImage(String filename) {
		return new Image(LOGO_IMAGE_ID, new PackageResourceReference(ImageProvider.class,filename));
	}
	
	/**
	 * Get the image.
	 * @param cid - Mark up id.
	 * @param filename - filename
	 * @return - the Image file.
	 */
	public static Image getImage(String cid,String filename) {
		return new Image(LOGO_IMAGE_ID, new PackageResourceReference(ImageProvider.class,filename));
	}
	
}
