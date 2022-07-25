import React from 'react';
import './RecentPost.css';

const Post = function () {
  return (
    <div className="post">
      <div className="post__img" />
      <div className="post-info">
        <span className="post-title">
          구름톡 업데이트 48시간 전, 그 치열함에
        </span>
        <span className="post-desc">
          안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는
          채상아 입니다. 이전 글에서 말씀드렸듯이 Android
        </span>
        <div className="post-tags">
          <span>#html </span>
          <span>#css </span>
        </div>
      </div>
      <div className="post-writer">
        <span className="writer-name">에코노베이션</span>
        <div className="writer-img" />
      </div>
    </div>
  );
};

export default Post;
