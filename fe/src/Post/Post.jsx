import React from 'react';

import './css/Post.css';

import Title from './components/Title';
import PostInfo from './components/PostInfo';
import Tags from './components/Tags';
import PostDesc from './components/PostDesc';
import CommentList from './components/CommentList';
import Liked from './components/Liked';

const Post = function () {
  return (
    <div className="post">
      <div className="post-middle">
        <Title />
        <PostInfo />
        <Tags />
        <PostDesc />
        <Liked />
        <CommentList />
      </div>
    </div>
  );
};

export default Post;
