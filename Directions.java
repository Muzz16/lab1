
    public enum Directions {
        NORTH(0),
        EAST(1),
        SOUTH(2),
        WEST(3);

        private final int value;
        Directions(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        public static Directions fromValue(int value) {
            for (Directions direction : Directions.values()) {
                if (direction.getValue() == value) {
                    return direction;
                }
            }
            throw new IllegalArgumentException("Invalid direction value: " + value);
        }

    }

