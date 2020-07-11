package cm.ubuea.covider;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PersonHomePagerAdapter extends FragmentPagerAdapter {
    private int numbrofTab;

    public PersonHomePagerAdapter(@NonNull FragmentManager fm, int numbrofTab) {
        super(fm, numbrofTab);
        this.numbrofTab = numbrofTab;
    }


    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new PersonPersonalInformation();
            case 1:
                return new PersonFamilyInformation();
            case 2:
                return new PersonMedicalInformation();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numbrofTab;
    }
}
