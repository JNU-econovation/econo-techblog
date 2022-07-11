import React from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';

import Main from './Main/Main';
import Login from './Login/Login';
import SignUp from './SignUp/SignUp';
import Write from './Write/Write';
import Manager from './Manager/Manager';
import FindInfo from './FindInfo/FindInfo';
import Layout from './Layout/Layout';

function App() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/" element={<Main />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/write" element={<Write />} />
        <Route path="/admin" element={<Manager />} />
        <Route path="/findinfo" element={<FindInfo />} />
      </Route>
    </Routes>
  );
}

export default App;
