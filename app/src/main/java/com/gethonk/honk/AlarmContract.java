package com.gethonk.honk;

import android.provider.BaseColumns;

/**
 * Created by karan on 01/07/15.
 */
public class AlarmContract {

    // To prevent someone from accedentally instantiating it, give it
    // an empty contructor
    public AlarmContract(){}

    public static final class AlarmEntry implements BaseColumns {

        public static final String TABLE_NAME = "alarm";

        // time at which alarm was set
        public static final String COLUMN_NAME_SET_TIME = "st";

        // hour at which alarm will go off
        public static final String COLUMN_NAME_ALARM_HOUR = "h";

        // minute at which alarm will go off
        public static final String COLUMN_NAME_ALARM_MIN = "m";

        // for a given instance of alarm being set off, after how much
        // time should it repeat itself. (minutes)
        public static final String COLUMN_NAME_REPEAT_AFTER = "ra";

        // for a given instance of alarm being set off, how many times should
        // it repeat itself.
        public static final String COLUMN_NAME_REPEAT_COUNT = "rc";

        // should the alarm explode everyday, weekday, weekend or selected
        // days (comma seperated strings)
        public static final String COLUMN_NAME_ACTIVE_RANGE = "ar";

        // what sound needs to be played when alarm is set off
        public static final String COLUMN_NAME_SOUND = "s";

        // name of alarm
        public static final String COLUMN_NAME_NAME = "n";

        // whether alarm is ready to go off at next activerange or not
        public static final String COLUMN_NAME_IS_ACTIVE = "ia";
    }

}
