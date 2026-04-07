class Robot {
private:
    int x, y;     // current position
    int dir;      // current direction

    int w, h;     // grid dimensions
    int tot;      // total perimeter steps

public:

    Robot(int width, int height) {

        // start position
        x = 0;
        y = 0;

        // initial direction is East
        dir = 1;

        w = width;
        h = height;

        // total steps to complete one full boundary cycle
        tot = 2 * w;
        tot += 2 * (h - 2);
    }

    void step(int num) {

        // Special case:
        // If we complete full cycles and are at origin,
        // direction becomes South
        if(num % tot == 0 && x == 0 && y == 0)
            dir = 2;

        // reduce unnecessary full cycles
        num %= tot;

        while(num) {

            // EAST
            if(dir == 1) {
                int step = w - x - 1;
                step = min(step, num);

                x += step;
                num -= step;
            }

            // NORTH
            else if(dir == 0) {
                int step = h - 1 - y;
                step = min(step, num);

                y += step;
                num -= step;
            }

            // WEST
            else if(dir == 3) {
                int step = min(x, num);

                x -= step;
                num -= step;
            }

            // SOUTH
            else if(dir == 2) {
                int step = min(y, num);

                y -= step;
                num -= step;
            }

            // turn counterclockwise if movement remains
            if(num)
                dir = (dir - 1 + 4) % 4;
        }
    }

    vector<int> getPos() {
        return {x, y};
    }

    string getDir() {

        if(dir == 1) return "East";
        if(dir == 0) return "North";
        if(dir == 3) return "West";

        return "South";
    }
};
