<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';

import LanguageItem from './LanguageItem';
import languageData from './data';
import CustomScrollbars from 'util/CustomScrollbars';

const LanguageSwitcher = ({switchLanguage, handleRequestClose}) => {
  return (
    <CustomScrollbars className="messages-list language-list scrollbar" style={{height: 230}}>
      <ul className="list-unstyled">
        {languageData.map((language, index) => <LanguageItem key={index} language={language}
                                                             handleRequestClose={handleRequestClose}
                                                             switchLanguage={switchLanguage}/>)}
      </ul>
    </CustomScrollbars>
  )
};

export default LanguageSwitcher;

=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';

import LanguageItem from './LanguageItem';
import languageData from './data';
import CustomScrollbars from 'util/CustomScrollbars';

const LanguageSwitcher = ({switchLanguage, handleRequestClose}) => {
  return (
    <CustomScrollbars className="messages-list language-list scrollbar" style={{height: 230}}>
      <ul className="list-unstyled">
        {languageData.map((language, index) => <LanguageItem key={index} language={language}
                                                             handleRequestClose={handleRequestClose}
                                                             switchLanguage={switchLanguage}/>)}
      </ul>
    </CustomScrollbars>
  )
};

export default LanguageSwitcher;

<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
