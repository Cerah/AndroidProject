package dk.via;

import com.developerlife.android.AnimUtils;
import com.developerlife.android.LayoutUtils;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class TableBuilder {
	public static View createList(Activity activity) {

		  // create the ui components
		  LinearLayout mainpanel = new LinearLayout(activity);
		  ListView listview = new ListView(activity);

		  // setup the mainpanel
		  {
		    // apply view group params for the activity's root pane
		    LayoutUtils.Layout.WidthFill_HeightFill.applyViewGroupParams(mainpanel);
		    // set animation layout on the mainpanel
		    AnimUtils.setLayoutAnim_slideupfrombottom(mainpanel, activity);
		  }

		  // setup the listview and add to the mainpanel
		  {
		    LayoutUtils.Layout.WidthFill_HeightFill.applyLinearLayoutParams(listview);

		    bindListViewToAdapter(activity, listview);

		    AnimUtils.setLayoutAnim_slidedownfromtop(listview, activity);

		    mainpanel.addView(listview);
		  }

		  // return the mainpanel
		  return mainpanel;
	}

	/** create the list data, and bind a custom adapter to the listview */
	private static void bindListViewToAdapter(Activity ctx, ListView listview) {

	  final FlightDataListAdapter listModelView = new FlightDataListAdapter(ctx, listview);

	  // bind a selection listener to the view
	  listview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	    public void onItemSelected(AdapterView parentView, View childView, int position, long id) {
	      listModelView.setSelected(position);
	    }
	    public void onNothingSelected(AdapterView parentView) {
	      listModelView.setSelected(-1);
	    }
	  });

	}
}
