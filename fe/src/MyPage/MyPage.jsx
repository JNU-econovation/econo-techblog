import React from 'react';

import './css/MyPage.css';
import MyPosts from './MyPosts';
import Profile from './Profile';

function MyPage() {
  return (
    <div className="my-page">
      <div className="my-page-wallpaper-color" />
      <Profile />
      <MyPosts />
    </div>
  );
}

export default MyPage;
