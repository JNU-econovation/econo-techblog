import React from 'react';

import '../css/CommentList.css';

import Comment from './Comment';

const CommentList = function () {
  return (
    <div className="comment-list">
      <span>댓글 3개</span>
      <div className="comment">
        <div className="writer-img" />
        <div className="comment-info">
          <span className="writer">이서현</span>
          <input />
        </div>
      </div>
      <Comment
        name="김수민"
        desc="안녕하세요 궁금한점이 있습니다! 만약에 사용자가 빌린 차를 세차한
        것이 아니라 구글링이나 다른 자동차를 세차한 이미지를 올린다면 이건
        어떤 방식으로 걸러내는 건가요?"
      />
    </div>
  );
};

export default CommentList;
