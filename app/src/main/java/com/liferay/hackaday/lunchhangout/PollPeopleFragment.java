package com.liferay.hackaday.lunchhangout;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.liferay.hackaday.lunchhangout.adapter.PeopleAdapter;
import com.liferay.hackaday.lunchhangout.adapter.PlaceAdapter;
import com.liferay.hackaday.lunchhangout.model.Poll;
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

	public static PollPeopleFragment create(Poll poll) {
		PollPeopleFragment fragment = new PollPeopleFragment();
		Bundle arguments = new Bundle();
		arguments.putParcelable("poll", poll);

		fragment.setArguments(arguments);

		return fragment;
	}

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

		Poll poll = getArguments().getParcelable("poll");
		JsonElement votes = poll.getVotes();
		List<User> list = new ArrayList<>();

		if (votes != null) {
			if (votes.isJsonArray()) {
				for (JsonElement jsonElement : votes.getAsJsonArray()) {
					list.add(new User(jsonElement.getAsString()));
				}
			}
			else if (votes.isJsonPrimitive()) {
				list.add(new User(votes.getAsString()));
			}
		}

	    adapter.setEntries(list);

      return view;
    }

}
