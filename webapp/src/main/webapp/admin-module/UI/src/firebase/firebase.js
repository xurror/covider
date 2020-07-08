import firebase from 'firebase'

// Initialize Firebase
const config = {
    apiKey: "AIzaSyBeCUPgUin3BXurPzw0TLsTFwpWfh9zSuA",
    authDomain: "dashboard-feb05.firebaseapp.com",
    databaseURL: "https://dashboard-feb05.firebaseio.com",
    projectId: "dashboard-feb05",
    storageBucket: "dashboard-feb05.appspot.com",
    messagingSenderId: "428158108820",
    appId: "1:428158108820:web:d6d65a95d1de483a492081",
    measurementId: "G-2E68TCBVH0"
};

firebase.initializeApp(config);
const auth = firebase.auth();

const googleAuthProvider = new firebase.auth.GoogleAuthProvider();
const facebookAuthProvider = new firebase.auth.FacebookAuthProvider();
const githubAuthProvider = new firebase.auth.GithubAuthProvider();
const twitterAuthProvider = new firebase.auth.TwitterAuthProvider();

const database = firebase.database();
export {
  auth,
  database,
  googleAuthProvider,
  githubAuthProvider,
  facebookAuthProvider,
  twitterAuthProvider
};