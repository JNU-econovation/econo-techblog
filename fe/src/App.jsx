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
import NewPassword from './NewPassword/NewPassword';
import Tech from './Tech/Tech';
import Post from './Post/Post';
import UserList from './Manager/components/UserList';
import UserInfo from './Manager/components/UserInfo';
import PostSearch from './PostSearch/PostSearch';
import RegistList from './Manager/components/RegistList';

function App() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/" element={<Main />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/write" element={<Write />} />
        <Route path="/findid" element={<FindID />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/findpassword" element={<FindPassword />} />
        <Route path="/newpassword" element={<NewPassword />} />
        <Route path="/posts" element={<Tech />}>
          <Route path=":category" element={<Tech />} />
        </Route>
        <Route path="/post/:id" element={<Post />} />
        <Route path="/admin" element={<Manager />}>
          <Route path="/admin/regist" element={<RegistList />} />
          <Route path="/admin/role" element={<UserList />}>
            <Route path=":role" element={<UserList />} />
          </Route>
          <Route path="/admin/user" element={<UserInfo />}>
            <Route path=":id" element={<UserInfo />} />
          </Route>
        </Route>
        <Route path="/search" element={<PostSearch />} />
      </Route>
    </Routes>
  );
}

export default App;
