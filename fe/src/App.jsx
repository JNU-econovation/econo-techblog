import React from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';

import Main from './Main/Main';
import Login from './Login/Login';
import SignUp from './SignUp/SignUp';
import Write from './Write/Write';
import Manager from './Manager/Manager';
import FindID from './FindID/FindID';
import Layout from './Layout/Layout';
import MyPage from './MyPage/MyPage';
import FindPassword from './FindPassword/FindPassword';

function App() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/" element={<Main />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/write" element={<Write />} />
        <Route path="/admin" element={<Manager />} />
        <Route path="/findid" element={<FindID />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/findpassword" element={<FindPassword />} />
      </Route>
    </Routes>
  );
}

export default App;
