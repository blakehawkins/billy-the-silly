package appathon.com.billythesilly;

import android.app.Activity;
import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link DialogFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BuyDialogFragment.OnDialogInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BuyDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuyDialogFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DESCRIPTION = "param1";
    private static final String ARG_IMAGE = "param2";

    // TODO: Rename and change types of parameters
    private String mDescription;
    private int mImageID;

    private OnDialogInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param description Parameter 1.
     * @param imageID Parameter 2.
     * @return A new instance of fragment BuyDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuyDialogFragment newInstance(String description, int imageID) {
        BuyDialogFragment fragment = new BuyDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DESCRIPTION, description);
        args.putInt(ARG_IMAGE, imageID);
        fragment.setArguments(args);
        return fragment;
    }

    public BuyDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setStyle(STYLE_NO_TITLE,0);
        if (getArguments() != null) {
            mDescription = getArguments().getString(ARG_DESCRIPTION);
            mImageID = getArguments().getInt(ARG_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_dialog, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onDialogInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnDialogInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnDialogInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnDialogInteractionListener {
        // TODO: Update argument type and name
        public void onDialogInteraction(Uri uri);
    }

}
