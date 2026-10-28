class Solution {
    class Pair{
        private int position;
        private int speed;
        public Pair(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] p = new Pair[position.length];
        for(int i=0;i<p.length;i++){
            p[i] = new Pair(position[i],speed[i]);
        }
        Arrays.sort(p,(a,b) -> Integer.compare(b.position,a.position));
        int fleets = 1;
        double prevTime = (double) (target-p[0].position)/p[0].speed;
        for(int i=1;i<position.length;i++){
            double curTime = (double) (target-p[i].position)/p[i].speed;
            if(curTime > prevTime){
                fleets++;
                prevTime = curTime;
            }
        }
        return fleets;
        
    }
}
