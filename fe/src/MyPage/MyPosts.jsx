import React from 'react';

import './css/MyPosts.css';

function MyPosts() {
  return (
    <div className="my-posts">
      <h3>내가 쓴 글(0)</h3>
      <div className="my-posts__container">아직 작성한 글이 없습니다.</div>
      <div className="my-posts-group__nav">좋아요 댓글</div>
      <div className="my-posts-group__container">글들 글들</div>
    </div>
  );
}

export default MyPosts;
