package image;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("in_most_viral")
	private boolean inMostViral;

	@JsonProperty("ad_type")
	private int adType;

	@JsonProperty("link")
	private String link;

	@JsonProperty("description")
	private Object description;

	@JsonProperty("section")
	private Object section;

	@JsonProperty("title")
	private Object title;

	@JsonProperty("type")
	private String type;

	@JsonProperty("deletehash")
	private String deletehash;

	@JsonProperty("datetime")
	private int datetime;

	@JsonProperty("has_sound")
	private boolean hasSound;

	@JsonProperty("id")
	private String id;

	@JsonProperty("in_gallery")
	private boolean inGallery;

	@JsonProperty("vote")
	private Object vote;

	@JsonProperty("views")
	private int views;

	@JsonProperty("height")
	private int height;

	@JsonProperty("bandwidth")
	private int bandwidth;

	@JsonProperty("nsfw")
	private Object nsfw;

	@JsonProperty("is_ad")
	private boolean isAd;

	@JsonProperty("edited")
	private String edited;

	@JsonProperty("ad_url")
	private String adUrl;

	@JsonProperty("tags")
	private List<Object> tags;

	@JsonProperty("account_id")
	private int accountId;

	@JsonProperty("size")
	private int size;

	@JsonProperty("width")
	private int width;

	@JsonProperty("account_url")
	private Object accountUrl;

	@JsonProperty("name")
	private String name;

	@JsonProperty("animated")
	private boolean animated;

	@JsonProperty("favorite")
	private boolean favorite;

	public boolean isInMostViral(){
		return inMostViral;
	}

	public int getAdType(){
		return adType;
	}

	public String getLink(){
		return link;
	}

	public Object getDescription(){
		return description;
	}

	public Object getSection(){
		return section;
	}

	public Object getTitle(){
		return title;
	}

	public String getType(){
		return type;
	}

	public String getDeletehash(){
		return deletehash;
	}

	public int getDatetime(){
		return datetime;
	}

	public boolean isHasSound(){
		return hasSound;
	}

	public String getId(){
		return id;
	}

	public boolean isInGallery(){
		return inGallery;
	}

	public Object getVote(){
		return vote;
	}

	public int getViews(){
		return views;
	}

	public int getHeight(){
		return height;
	}

	public int getBandwidth(){
		return bandwidth;
	}

	public Object getNsfw(){
		return nsfw;
	}

	public boolean isIsAd(){
		return isAd;
	}

	public String getEdited(){
		return edited;
	}

	public String getAdUrl(){
		return adUrl;
	}

	public List<Object> getTags(){
		return tags;
	}

	public int getAccountId(){
		return accountId;
	}

	public int getSize(){
		return size;
	}

	public int getWidth(){
		return width;
	}

	public Object getAccountUrl(){
		return accountUrl;
	}

	public String getName(){
		return name;
	}

	public boolean isAnimated(){
		return animated;
	}

	public boolean isFavorite(){
		return favorite;
	}
}