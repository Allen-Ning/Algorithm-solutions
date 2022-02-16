class Robot {

    int width;
    int height;
    String[] directions = new String[] {"East", "North", "West", "South"};
    int dirIndex;
    int total;
    int x;
    int y;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.total = (2 * width + 2 * height) - 4;
    }

    public void step(int num) {
        // trick -> corner case when robot is at the starting point
        if (dirIndex == 0 && x == 0 && y== 0) {
            num %= total;
            this.dirIndex = getPrevDir();
        }
        helper(num);
    }

    private void helper(int num) {
        // trick -> when robot is at the borders 
        if (x == 0 || y == 0 || x == width - 1 || y == height - 1) num %= total;

        if (dirIndex == 0) {
            if (x + num < width) {
                x += num;
                return;
            }

            num -= (width - 1 - x);
            x = width - 1;
        } else if (dirIndex == 1) {
            if (y + num < height) {
                y += num;
                return;
            }

            num -= (height - 1 - y);
            y = height - 1;
        } else if (dirIndex == 2) {
            if (x - num >= 0) {
                x -= num;
                return;
            }

            num -= x;
            x = 0;
        } else if (dirIndex == 3) {
            if (y - num >= 0) {
                y -= num;
                return;
            }

            num -= y;
            y = 0;
        }
        dirIndex = getNextDir();
        helper(num);
    }

    private int getPrevDir() {
        return (this.dirIndex - 1 + 4) % 4;
    }

    private int getNextDir() {
        return (this.dirIndex + 1) % 4;
    }

    public int[] getPos() {
        return new int[] {x, y};
    }

    public String getDir() {
        return directions[this.dirIndex];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */