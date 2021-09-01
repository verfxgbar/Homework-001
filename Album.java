@SuppressWarnings("unused")
public class Album
{
	private Picture[] pictures;
	private String name;
	private Profile owner;

	public Album(Profile owner, String name)
	{
		this.name = name;
		this.owner = owner;
	}

	public Picture[] getPictures()
	{
		return pictures;
	}

	public Profile getOwner()
	{
		return owner;
	}

	public void addPicture(Profile profile, Picture picture)
	{
		if (this.owner == profile)
		{
			Picture[] oldArray = pictures;
			pictures = new Picture[oldArray.length];
			for (int i = 0; i < oldArray.length - 1; i++)
				pictures[i] = oldArray[i];
			pictures[oldArray.length] = picture;
		}
	}

	public void removePicture(Profile profile, Picture picture)
	{
		if (this.owner == profile)
		{
			for (int i = 0; i < pictures.length - 1; i++)
				if (pictures[i] == picture)
					pictures[i] = null;
			Picture[] newArray = new Picture[pictures.length - 2];
			int count = 0;
			for (int i = 0; i < pictures.length - 1; i++)
			{
				if (pictures[i] == null)
				{
					count++;
					continue;
				}
				newArray[i] = pictures[i - count];
			}
		}
	}
}
