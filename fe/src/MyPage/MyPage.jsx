import React from 'react';

import './css/MyPage.css';

function MyPage() {
  return (
    <div className="my-page">
      <div className="my-page-wallpaper-color" />
      <div className="profile">
        <h2>내 정보</h2>
        <h3>프로필</h3>
        <div className="profile__container">
          <div className="profile-content__container">
            <img alt="profile_img" className="profile__img" />
            <div className="profile-description__container">
              <p>이윤성 님</p>
              <p>182761@jnu.ac.kr</p>
              <p> 21기 | 일반 회원</p>
            </div>
          </div>
          <button type="button">내 정보 수정</button>
        </div>
        <div className="profile-stat__container">
          <div className="profile-stat-like__container">
            <p>받은 좋아요</p>
            <p>0 개</p>
          </div>
          <div className="profile-stat-comment__container">
            <p>받은 댓글</p>
            <p>0 개</p>
          </div>
        </div>
      </div>

      <div className="my-posts">
        <h3>내가 쓴 글(0)</h3>
        <div className="my-posts__container">아직 작성한 글이 없습니다.</div>
        <div className="my-posts-group__nav">좋아요 댓글</div>
        <div className="my-posts-group__container">글들 글들</div>
      </div>
    </div>
  );
}

export default MyPage;
