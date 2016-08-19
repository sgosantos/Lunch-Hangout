package com.liferay.hackaday.lunchhangout;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liferay.hackaday.lunchhangout.adapter.PeopleAdapter;
import com.liferay.hackaday.lunchhangout.adapter.PlaceAdapter;
import com.liferay.hackaday.lunchhangout.model.User;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class PollPeopleFragment extends Fragment {

	RecyclerView recyclerView;
	PeopleAdapter adapter;
	List<User> peopleWhoVoted;

	public PollPeopleFragment() {
        // Required empty public constructor
    }

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_poll_people, container, false);

	    recyclerView = (RecyclerView)  view.findViewById(R.id.recycler_view);

	    recyclerView.setHasFixedSize(true);
	    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
	    adapter = new PeopleAdapter(getActivity());
	    recyclerView.setAdapter(adapter);

//	    pegar lista de pessoas vontantes
		User aux = new User("Silvio");
		User aux1 = new User("Igor");

		List<User> list = new ArrayList<>();
		list.add(aux);
		list.add(aux1);

	    adapter.setEntries(list);

      return view;
    }

}
