import React, { useState } from 'react';

import './css/MyPage.css';
import MyPosts from './MyPosts';
import Profile from './Profile';

function MyPage() {
  const [isMyInfoSelect, setIsMyInfoSelect] = useState(false);

  return (
    <div className="my-page">
      <div className="my-page-wallpaper-color" />
      <h2>내 정보</h2>
      <div className="my-page__content">
        <Profile
          isMyInfoSelect={isMyInfoSelect}
          setIsMyInfoSelect={setIsMyInfoSelect}
        />
        {isMyInfoSelect ? <div /> : <MyPosts />}
      </div>
    </div>
  );
}

export default MyPage;
