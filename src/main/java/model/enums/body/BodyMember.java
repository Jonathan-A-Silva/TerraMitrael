package model.enums.body;

import java.util.List;

public enum BodyMember {

    HUMAN_HEAD(List.of(
            BodyParts.HEAD,
            BodyParts.LEFT_EYE,
            BodyParts.RIGHT_EYE,
            BodyParts.LEFT_EAR,
            BodyParts.RIGHT_EAR,
            BodyParts.NOSE,
            BodyParts.MOUTH
    )),

    HUMAN_BODY(List.of(
            BodyParts.BODY
    )),

    HUMAN_LEFT_ARM(List.of(
            BodyParts.LEFT_ARM,
            BodyParts.LEFT_HAND,
            BodyParts.LEFT_THUMB,
            BodyParts.LEFT_INDEX_FINGER,
            BodyParts.LEFT_MIDDLE_FINGER,
            BodyParts.LEFT_RING_FINGER,
            BodyParts.LEFT_LITTLE_FINGER
    )),

    HUMAN_RIGHT_ARM(List.of(
            BodyParts.RIGHT_ARM,
            BodyParts.RIGHT_HAND,
            BodyParts.RIGHT_THUMB,
            BodyParts.RIGHT_INDEX_FINGER,
            BodyParts.RIGHT_MIDDLE_FINGER,
            BodyParts.RIGHT_RING_FINGER,
            BodyParts.RIGHT_LITTLE_FINGER
    )),

    HUMAN_LEFT_LEG(List.of(
            BodyParts.LEFT_LEG,
            BodyParts.LEFT_FEET
    )),

    HUMAN_RIGHT_LEG(List.of(
            BodyParts.RIGHT_LEG,
            BodyParts.RIGHT_FEET
    ));
    private final List<BodyParts> parts;

    BodyMember(List<BodyParts> parts) {
        this.parts = parts;
    }

    public List<BodyParts> getParts() {
        return parts;
    }


}
