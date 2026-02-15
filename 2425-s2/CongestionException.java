class CongestionException extends Exception {
  public CongestionException(int id) {
    super("Q" + id + " is congested");
  }
}
