import './App.css';
import React from 'react';
import  UserSignupPage  from './pages/UserSıgnupPage';
import UserLoginPage from './pages/UserLoginPage';
import LanguageSelector from './components/LanguageSelector';

function App() {
  return (
    <div className="App">
        <UserSignupPage/>
        <br/>
        <UserLoginPage/>
        <LanguageSelector/>
    </div>
  );
}

export default App;
