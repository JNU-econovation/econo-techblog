import React, { useState } from 'react';

import './css/MyPosts.css';

function MyPosts() {
  const [type, setType] = useState('like');
  const onLikeClick = () => {
    setType(() => 'like');
  };
  const onCommentClick = () => {
    setType(() => 'comment');
  };
  return (
    <div className="my-posts">
      <h3>내가 쓴 글(0)</h3>
      <div className="my-posts__container">아직 작성한 글이 없습니다.</div>
      <div className="my-posts-group__nav">
        <button
          className={`my-posts-nav__button ${
            type === 'like' ? 'nav__button--active' : ''
          }`}
          type="button"
          onClick={onLikeClick}
        >
          좋아요(2)
        </button>
        <button
          className={`my-posts-nav__button ${
            type === 'comment' ? 'nav__button--active' : ''
          }`}
          type="button"
          onClick={onCommentClick}
        >
          댓글(5)
        </button>
      </div>
      <div className="my-posts-group__container">글들 글들 글들</div>
    </div>
  );
}

export default MyPosts;
