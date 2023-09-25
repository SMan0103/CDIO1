public class Player {
        public final String playerName;
        private int score;
        public Player(String playerName) {
            this.playerName = playerName;
            this.score = 0;
        }

        public int getScore() {
            return score;
        }
        public void addScore(int toadd) {
            score += toadd;
        }
}
