<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';


const LanguageItem = ({language, switchLanguage, handleRequestClose}) => {
  const {icon, name} = language;
  return (
    <li className="pointer" onClick={() => {
      handleRequestClose();
      switchLanguage(language);
    }}>
      <div className="d-flex align-items-center">
        <i className={`flag flag-24 flag-${icon}`}/>
        <h4 className="mb-0 ml-2">{name}</h4>
      </div>
    </li>
  );
};

export default LanguageItem;
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';


const LanguageItem = ({language, switchLanguage, handleRequestClose}) => {
  const {icon, name} = language;
  return (
    <li className="pointer" onClick={() => {
      handleRequestClose();
      switchLanguage(language);
    }}>
      <div className="d-flex align-items-center">
        <i className={`flag flag-24 flag-${icon}`}/>
        <h4 className="mb-0 ml-2">{name}</h4>
      </div>
    </li>
  );
};

export default LanguageItem;
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
