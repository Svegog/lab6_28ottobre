package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 *
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    Set<U> totalPeopleFollowed = new HashSet<>();
    Map<String,Set<U>> peopleFollowedByGroup = new HashMap<>();
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }

    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, -1);
    }

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        if (!totalPeopleFollowed.contains(user))
        {
            totalPeopleFollowed.add(user);
        }

        Set<U> usersInGroup = peopleFollowedByGroup.get(circle);

        if (usersInGroup==null) {
            usersInGroup = new HashSet<>();
            peopleFollowedByGroup.put(circle, usersInGroup);
        }

        if (!usersInGroup.contains(user)) {
            usersInGroup.add(user);
            return true;
        }

        return false;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        if (peopleFollowedByGroup.containsKey(groupName)) {
            return new ArrayList<>(peopleFollowedByGroup.get(groupName)); 
        }
        return new ArrayList<>();
    }

    @Override
    public List<U> getFollowedUsers() {
        return new ArrayList<>(totalPeopleFollowed);
    }
}
