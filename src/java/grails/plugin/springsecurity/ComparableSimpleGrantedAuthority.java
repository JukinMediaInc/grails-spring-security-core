package grails.plugin.springsecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * Getting deserialization errors on non-Comparable SimpleGrantedAuthority, so replace it with this.
 *
 * Created by jerry on 11/1/14.
 */
public class ComparableSimpleGrantedAuthority implements Serializable, Comparable<ComparableSimpleGrantedAuthority>, GrantedAuthority {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final String role;

    public ComparableSimpleGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }

    public boolean equals(Object obj) {
        return this == obj || obj instanceof ComparableSimpleGrantedAuthority && role.equals(((ComparableSimpleGrantedAuthority) obj).role);
    }

    public int hashCode() {
        return this.role.hashCode();
    }

    public String toString() {
        return this.role;
    }

    public int compareTo(ComparableSimpleGrantedAuthority object) {
        return object.role.compareTo(this.role);
    }
}
