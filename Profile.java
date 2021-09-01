@SuppressWarnings("unused")
public class Profile
{
	private Profile self;
	private String name;
	private int alter;
	private long createDate;
	public int likes;
	public Album alben;
	public Group[] gruppen;
	public Race rasse;

	public Profile(String name, int alter, Race rasse)
	{
		this.self = this;
		this.name = name;
		this.alter = alter;
	}

	public int getAlter()
	{
		return alter;
	}

	public String getName()
	{
		return name;
	}

	public void createAlbum(String albumName)
	{
		Album album = new Album(this.self, albumName);
	}

	public Album getAlben()
	{
		return alben;
	}

	public void createGroup(String groupName)
	{
		Group group = new Group(groupName);
		group.addMember(this.self);
		group.setAdmin(this.self);
	}

	public void addUserToGroup(Group group, Profile profile)
	{
		if (group.isAdmin(this.self) && group.isMember(this.self))
			group.addMember(profile);
	}

	public void removeUserFromGroup(Group group, Profile profile)
	{
		if (group.isAdmin(this.self) && group.isMember(this.self))
			group.kickMemberFromGroup(profile);
	}

	public Group[] getGruppen()
	{
		return gruppen;
	}

	public int getLikes()
	{
		return likes;
	}

	public void setLikes(int likes)
	{
		this.likes = likes;
	}

	public void setRasse(Race rasse)
	{
		this.rasse = rasse;
	}
}
