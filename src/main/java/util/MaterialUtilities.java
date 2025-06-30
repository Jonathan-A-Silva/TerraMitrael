package util;

import java.util.List;

import model.enums.MaterialRole;

public class MaterialUtilities {

    private final List<MaterialRole> roles;

    public MaterialUtilities(MaterialRole... roles) {
        this.roles = List.of(roles);
    }

    public boolean canBeUsedAs(MaterialRole role) {
        return roles.contains(role);
    }

}
