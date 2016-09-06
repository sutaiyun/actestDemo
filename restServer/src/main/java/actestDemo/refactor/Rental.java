package actestDemo.refactor;

/**
 * Created by sutaiyun on 2016/8/20.
 */
public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getdaysRented() {
       return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }
}
