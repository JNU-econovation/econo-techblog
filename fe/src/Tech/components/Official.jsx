/* eslint-disable jsx-a11y/control-has-associated-label */
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { gql, useMutation } from '@apollo/client';

import '../css/Official.css';
import noImg from '../img/no_img.png';
import PostDetails from '../../components/PostDetails';
import Tags from '../../components/Tags';

const FIND_OFFICIAL = gql`
  mutation findOfficial {
    findOfficial {
      postId
      userName
      content
      title
      mainCategoryNumber
      categoryName
      createdDate
      views
      hearts
    }
  }
`;

const Official = function () {
  const [officialPosts, setOfficialPosts] = useState([]);
  const [currentPost, setCurrentPost] = useState();
  const [currentIndex, setCurrentIndex] = useState(0);
  const [findOfficial, { loading }] = useMutation(FIND_OFFICIAL, {
    // eslint-disable-next-line no-shadow
    onCompleted(data) {
      console.log('findOfficial', data.findOfficial);
      setOfficialPosts(data.findOfficial);
    },
  });
  useEffect(() => {
    console.log('여기!!!!');
    findOfficial();
  }, []);

  useEffect(() => {
    const timeoutId = setTimeout(() => {
      setCurrentIndex((currentValue) => {
        if (currentValue < officialPosts.length - 1) {
          return currentValue + 1;
        }
        return 0;
      });
    }, 3500);
    return () => clearTimeout(timeoutId);
  }, [officialPosts]);

  useEffect(() => {
    setCurrentPost(officialPosts[currentIndex]);
  }, [currentIndex, officialPosts]);

  const onClick = (direction) => {
    setCurrentIndex(direction);
  };

  if (loading || !currentPost) return null;
  return (
    <div className="official">
      <Link
        to={`/post/${currentPost.postId}`}
        style={{ textDecoration: 'none' }}
      >
        <div className="official-post">
          <div className="official__img" />
          <div className="official-info">
            <div className="official-info-top">
              <span className="official-title">{currentPost.title}</span>
              <Tags tags={currentPost.categoryName} />
            </div>
            <div className="official-info-middle">
              <span>랄라라라</span>
            </div>
            <div className="official-info-bottom">
              <div className="official-info-bottom-left">
                <img
                  src={noImg}
                  alt="no-img"
                  className="official-info-bottom-left__img"
                />
                <span className="official-info-bottom-left__span">
                  {currentPost.userName}
                </span>
              </div>
              <PostDetails
                date="2022.05.04"
                views={currentPost.views}
                hearts={currentPost.hearts}
              />
            </div>
          </div>
        </div>
      </Link>
      <div className="official-bottom">
        {officialPosts.map((post, index) => (
          <button
            key={post.postId}
            type="button"
            onClick={() => onClick(index)}
            className={
              currentIndex === index
                ? 'official__button official__button--current'
                : 'official__button'
            }
          />
        ))}
      </div>
    </div>
  );
};
export default Official;
