import React from 'react';
import './RecentPost.css';

const RecentPost = function () {
  return (
    <div className="recent-post">
      <div className="recent-post__img" />
      <div className="recent-post-info">
        <span className="recent-post-title">
          구름톡 업데이트 48시간 전, 그 치열함에
        </span>
        <span className="recent-post-desc">
          안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는
          채상아 입니다. 이전 글에서 말씀드렸듯이 Android 안녕하세요.
          우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다.
          이전 글에서 말씀드렸듯이 Android
        </span>
        <div className="recent-post-tags">
          <span>#html </span>
          <span>#css </span>
        </div>
      </div>
      <div className="recent-post-writer">
        <span className="writer-name">에코노베이션</span>
        <div className="writer-img" />
      </div>
    </div>
  );
};

export default RecentPost;
