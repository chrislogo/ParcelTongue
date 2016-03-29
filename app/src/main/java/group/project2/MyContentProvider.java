package group.project2;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

/**
 * Created by The Red Comet on 3/24/2016.
 */
public class MyContentProvider extends ContentProvider {

    public final static String DBNAME = "ParcelTongue";

    public final static String TABLE_MESSAGES = "Messages";
    public final static String COLUMN_TIMESTAMP = "Timestamp";
    public final static String COLUMN_CONVERSATION_ID = "Conversation_ID";
    public final static String COLUMN_MESSAGE_TEXT = "Message_Text";

    public final static String TABLE_CONVERSATIONS = "Conversations";
    public final static String COLUMN_HASH_KEY = "Hash_Key";
    public final static String COLUMN_SERVER_IP = "Server_IP";

    /*
    For use later, if there's another needed table

    public final static String TABLE_ = "ParcelTongue";
    public final static String DBNAME1 = "ParcelTongue";
    public final static String DBNAME2 = "ParcelTongue";
    public final static String DBNAME3 = "ParcelTongue";
    */
    public static final String AUTHORITY = "group.project2";

    public static final Uri MESSAGES_URI = Uri.parse(
            "content://group.project2/" + TABLE_MESSAGES);
    public static final Uri CONVERSATIONS_URI = Uri.parse(
            "content://group.project2/" + TABLE_CONVERSATIONS);

    /*
    public static final Uri _URI = Uri.parse(
                "content://group.project2/" + TABLE_);
    */

    private static UriMatcher sUriMatcher;

    private MainDatabaseHelper mOpenHelper;

    private static final String SQL_CREATE_MAIN = "CREATE TABLE " +
            TABLE_MESSAGES + //Table Name
            "(" +
            " _ID INTEGER PRIMARY KEY, " +
            COLUMN_TIMESTAMP +
            " DATETIME, " +
            COLUMN_CONVERSATION_ID +
            " INTEGER FOREIGN KEY REFERENCES " +
            TABLE_CONVERSATIONS +
            "._ID, " +
            COLUMN_MESSAGE_TEXT +
            " TEXT); CREATE TABLE " +
            TABLE_CONVERSATIONS +
            "(" +
            " _ID INTEGER PRIMARY KEY, " +
            COLUMN_HASH_KEY +
            " VARCHAR, " +
            COLUMN_SERVER_IP +
            " VARCHAR);";
    //Not finished with this DB build just yet, but I'll finish up tomorrow.

    @Override
    public boolean onCreate() {
        mOpenHelper = new MainDatabaseHelper(getContext());

        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        }
    }
}
