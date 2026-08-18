class MyCalendar {

    List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {

        int left = 0;
        int right = bookings.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (bookings.get(mid)[0] < startTime) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left > 0 && bookings.get(left - 1)[1] > startTime) {
            return false;
        }

        if (left < bookings.size() && bookings.get(left)[0] < endTime) {
            return false;
        }

        bookings.add(left, new int[]{startTime, endTime});

        return true;
    }
}