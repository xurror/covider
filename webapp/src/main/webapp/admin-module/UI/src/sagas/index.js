<<<<<<< HEAD
<<<<<<< HEAD
import {all} from 'redux-saga/effects';
import toDoSagas from './Todo';
import authSagas from './Auth';

export default function* rootSaga(getState) {
  yield all([
    toDoSagas(),
    authSagas()
  ]);
}
=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import {all} from 'redux-saga/effects';
import toDoSagas from './Todo';
import authSagas from './Auth';

export default function* rootSaga(getState) {
  yield all([
    toDoSagas(),
    authSagas()
  ]);
}
<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
