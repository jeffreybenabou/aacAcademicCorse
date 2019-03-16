package com.example.jeffrey.academic.final_assignment_first_semester;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jeffrey.academic.R;

import java.util.ArrayList;
import java.util.Objects;

public class ItemsActivity extends AppCompatActivity {

    public static ArrayList<Destination>destinationArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        defineTheItems();
        setTheTitle();

    }

    @SuppressLint("SetTextI18n")
    private void setTheTitle() {
        TextView textView=findViewById(R.id.welcome_end_semster);
        textView.setText("ברוך הבא "+ Objects.requireNonNull(getIntent().getExtras()).getString("userName"));
    }

    public void onClickItem(View view)
    {
        Intent intent=new Intent(this,DestinationActivity.class);
        switch (view.getId())
        {
            case R.id.mexico:
                intent.putExtra("index",0);
                break;
            case R.id.hawaiian:
                intent.putExtra("index",1);
                break;
            case R.id.machu:
                intent.putExtra("index",2);
                break;
            case R.id.thailand:
                intent.putExtra("index",3);
                break;
        }
        startActivity(intent);
    }

    private void defineTheItems() {
        destinationArrayList=new ArrayList<>();
        destinationArrayList.add(new Destination(
                "Machu picchu"
                ,"מאצ'ו פיצ'ו (Matchu Pichu) נחשב לאחד מהאתרים היפים, אפופי הסודיות והמרהיבים ביותר בפרו ובעולם כולו. זוהי אחת מערי האינקה היחידות שנשארו כמעט בשלמותן ולא נהרסו על ידי הספרדים. בזמן שבני האינקה הפיקו תועלת מפסגות הרי האנדים (2760 מטר), בנו מבנים מאבנים כבדות ומאסיביות החל מתחילת המאה ה-15, אגדות מיסתיות ושמועות גרסו שהמאצ'ו פיצ'ו (משמעות השם \"פיסגה עתיקה\") הוא מקום קדוש עוד מתקופות קדומות ביותר. יהיה אשר יהיה מוצאו, בני האינקה הפכו את הפיסגה לעיר קטנה (8 קילומטרים רבועים) ויוצאת מן הכלל. כיום מדובר באתר התיירות הפופולארי והרווחי ביותר בפרו, המושך אליו המוני מבקרים מרחבי העולם. סביר להניח שגם אתם לא תפסחו עליו.\n" +
                "\n"
                ,"3500$"
                ,"256ha אל על"
                ,"28/07/19"
                ,R.drawable.machu));


        destinationArrayList.add(new Destination(
                "Thailand"
                ,"בעשור האחרון תאילנד הפכה ליעד המועדף על ישראלים רבים. אין זה פלא... תאילנד מציעה גיוון גדול של דברים לראות ולעשות, חוויות, פינוקים ובמחירים זולים.\n" +
                "      \n" +
                "\n" +
                "תאילנד היא גן עדן של ממש. מתאים לכולם – צעירים, זוגות, משפחות, מבוגרים וגם בני הגיל השלישי.\n" +
                "\n" +
                "         \n" +
                "\n" +
                "אז מה יש בתאילנד?\n" +
                "\n" +
                "    \n" +
                "תאילנד מכילה חופים מרהיבים בדרום, איים ועיירות חוף, מקומות הומים עם ספורט ימי, קניונים, מסיבות וחיי לילה עשירים לצד מקומות שקטים ופסטורליים שזוגות צעירים או סתם אנשים המחפשים שקט ימצאו בהם שלווה חלומית."
                ,"5000$"
                ,"5325 a"
                ,"17/08/19"
                ,R.drawable.thiland));




        destinationArrayList.add(new Destination(
                "Mexico "
                ,"מקסיקו היא מדינה תוססת, מרתקת, יפהפייה, היסטורית, בעלת ארכיטקטורה עשירה, מלאה באנשים ידידותיים ובאנרגיה מעולם אחר (ועל האוכל אין באמת צורך להכביר במילים). משרידי תרבות המאיה ההיסטוריים, דרך מקסיקו סיטי המודרנית שלא נחה לרגע, ועד לחופים האקזוטיים של קנקון – מקסיקו היא ככל הנראה החוויה המסעירה ביותר שתחוו אי פעם."
                ,"5500$"
                ,"48ff"
                ,"05/12/19"
                ,R.drawable.playadel));


        destinationArrayList.add(new Destination(
                "Hawaiian"
                ,"דמיינו את הוואי חזק חזק - ככה היא בדיוק: חופים לבנים, ים טורקיז, הרי געש, פרחים מרהיבים, אתרי גלישה ברמה עולמית, לווייתנים, חולצות פרחוניות ושמחת חיים. כן, יש גם המון תיירים, וגם קצת יקר, אבל פעם אחת בחיים כדאי לבקר בה"
                ,"2500$"
                ,"15c"
                ,"05/04/20"
                ,R.drawable.hawwai));

        setItems(R.id.mexico,R.id.mexico_text,0);
        setItems(R.id.hawaiian,R.id.hawaiian_text,1);
        setItems(R.id.machu,R.id.machu_text,2);
        setItems(R.id.thailand,R.id.thailand_text,3);
    }

    private void setItems(int mexico, int mexico_text,int location) {
        TextView textView=findViewById(mexico_text);
        ImageButton imageButton=findViewById(mexico);
        textView.setText(destinationArrayList.get(location).getNameOfCountry());
        imageButton.setImageDrawable(getDrawable(destinationArrayList.get(location).getImageId()));

    }
}
