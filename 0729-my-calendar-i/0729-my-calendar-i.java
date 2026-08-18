class MyCalendar {

    private List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {

        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];

            // Overlap condition
            if (startTime < end && start < endTime) {
                return false;
            }
        }

        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}