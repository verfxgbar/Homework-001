package de.robinKrestel.main;

@SuppressWarnings("unused")
public class Group
{
	private Profile[] profiles;
	private Profile[] admins;
	private String groupName;
	private Race raceGroup;

	public Group(String groupName)
	{
		this.groupName = groupName;
	}

	public Profile[] getProfiles()
	{
		return profiles;
	}

	public String getGroupName()
	{
		return groupName;
	}

	public void addMember(Profile profile)
	{
		Profile[] oldArray = profiles;
		profiles = new Profile[oldArray.length];
		for (int i = 0; i < oldArray.length - 1; i++)
			profiles[i] = oldArray[i];
		profiles[oldArray.length] = profile;
	}

	public boolean isMember(Profile profile)
	{
		for (Profile p : profiles)
			if (p.equals(profile))
				return true;
		return false;
	}

	public void kickMemberFromGroup(Profile profile)
	{
		for (int i = 0; i < profiles.length - 1; i++)
			if (profiles[i] == profile)
				profiles[i] = null;
		Profile[] newArray = new Profile[profiles.length - 2];
		int count = 0;
		for (int i = 0; i < profiles.length - 1; i++)
		{
			if (profiles[i] == null)
			{
				count++;
				continue;
			}
			newArray[i] = profiles[i - count];
		}
	}

	public Profile[] getMembers()
	{
		return profiles;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public void setAdmin(Profile newAdmin)
	{
		Profile[] oldArray = admins;
		admins = new Profile[oldArray.length];
		for (int i = 0; i < oldArray.length - 1; i++)
			admins[i] = oldArray[i];
		admins[oldArray.length] = newAdmin;
	}

	public boolean isAdmin(Profile profile)
	{
		for (Profile p : admins)
			if (p.equals(profile))
				return true;
		return false;
	}

	public void removeAdmin(Profile oldAdmin)
	{
		for (int i = 0; i < admins.length - 1; i++)
			if (admins[i] == oldAdmin)
				admins[i] = null;
		Profile[] newArray = new Profile[admins.length - 2];
		int count = 0;
		for (int i = 0; i < admins.length - 1; i++)
		{
			if (admins[i] == null)
			{
				count++;
				continue;
			}
			newArray[i] = admins[i - count];
		}
	}

	public Profile[] getAdmins()
	{
		return admins;
	}

	public Race getRaceGroup()
	{
		return raceGroup;
	}
}
