package model.enums.body;

import java.util.List;

public enum Body {

    HUMANOID(List.of(
            BodyMember.HUMAN_HEAD,
            BodyMember.HUMAN_BODY,
            BodyMember.HUMAN_LEFT_ARM,
            BodyMember.HUMAN_RIGHT_ARM,
            BodyMember.HUMAN_LEFT_LEG,
            BodyMember.HUMAN_RIGHT_LEG
    ));

    private List<BodyMember> members;

    Body(List<BodyMember> members) {
        this.members = members;
    }

    public List<BodyMember> getMembers() {
        return members;
    }

}
