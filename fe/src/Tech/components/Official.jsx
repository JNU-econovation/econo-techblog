/* eslint-disable jsx-a11y/control-has-associated-label */
import React, { useEffect, useState } from 'react';
// import { gql, useMutation } from '@apollo/client';

import '../css/Official.css';
import noImg from '../img/no_img.png';
import PostDetails from '../../components/PostDetails';
import Tags from '../../components/Tags';

// const FIND_OFFICIAL = gql`
//   mutation findOfficial {
//     findOfficial {
//       postId
//       userName
//       content
//       title
//       mainCategoryNumber
//       categoryName
//       createdDate
//       views
//       hearts
//     }
//   }
// `;

const result = [
  {
    pid: 1,
    author: '에코노베이션',
    title: 'slider1',
    desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다.이전 글에서 말씀드렸듯이 Android 구름톡을 가지고 돌아왔습니다. 지난 2월, 구름톡 성과를 가지고 전사 발표까지 하게 됐는데요. 정말 영광이었습니다. 발표를 하고 나서 가장 공감받았던 부분은 바로 “정말 힘들었습니다” (한숨) 부분이었습니다. 안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다.이전 글에서 말씀드렸듯이 Android 구름톡을 가지고 돌아왔습니다. 지난 2월, 구름톡 성과를 가지고 전사 발표까지 하게 됐는데요. 정말 영광이었습니다. 발표를 하고 나서 가장 공감받았던 부분은 바로 “정말 힘들었습니다” (한숨) 부분이었습니다.',
    date: '2021.05.04',
    looked: 21,
    liked: 21,
  },
  {
    pid: 2,
    author: '에코노베이션',
    title: 'slider2',
    desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다.이전 글에서 말씀드렸듯이 Android 구름톡을 가지고 돌아왔습니다. 지난 2월, 구름톡 성과를 가지고 전사 발표까지 하게 됐는데요. 정말 영광이었습니다. 발표를 하고 나서 가장 공감받았던 부분은 바로 “정말 힘들었습니다” (한숨) 부분이었습니다. 안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다.이전 글에서 말씀드렸듯이 Android 구름톡을 가지고 돌아왔습니다. 지난 2월, 구름톡 성과를 가지고 전사 발표까지 하게 됐는데요. 정말 영광이었습니다. 발표를 하고 나서 가장 공감받았던 부분은 바로 “정말 힘들었습니다” (한숨) 부분이었습니다.',
    date: '2021.05.04',
    looked: 21,
    liked: 21,
  },
  {
    pid: 3,
    author: '에코노베이션',
    title: 'slider3',
    desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다.이전 글에서 말씀드렸듯이 Android 구름톡을 가지고 돌아왔습니다. 지난 2월, 구름톡 성과를 가지고 전사 발표까지 하게 됐는데요. 정말 영광이었습니다. 발표를 하고 나서 가장 공감받았던 부분은 바로 “정말 힘들었습니다” (한숨) 부분이었습니다. 안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다.이전 글에서 말씀드렸듯이 Android 구름톡을 가지고 돌아왔습니다. 지난 2월, 구름톡 성과를 가지고 전사 발표까지 하게 됐는데요. 정말 영광이었습니다. 발표를 하고 나서 가장 공감받았던 부분은 바로 “정말 힘들었습니다” (한숨) 부분이었습니다.',
    date: '2021.05.04',
    looked: 21,
    liked: 21,
  },
];

const Official = function () {
  const [currentPost, setCurrentPost] = useState(result[0]);
  const [currentIndex, setCurrentIndex] = useState(0);
  // const [findOfficial] = useMutation(FIND_OFFICIAL, {
  //   // eslint-disable-next-line no-shadow
  //   onCompleted(data) {
  //     console.log(data);
  //     // setOfficialList(data);
  //     // if (findOfficial.length > 0) setCurrentPost(officialList[0]);
  //   },
  // });
  // useEffect(() => {
  //   findOfficial();
  // }, []);
  useEffect(() => {
    const timeoutId = setTimeout(() => {
      setCurrentIndex((currentValue) => {
        if (currentValue < result.length - 1) {
          return currentValue + 1;
        }
        return 0;
      });
    }, 2500);
    return () => clearTimeout(timeoutId);
  });
  useEffect(() => {
    setCurrentPost(result[currentIndex]);
  }, [currentIndex]);
  const onClick = (direction) => {
    setCurrentIndex(direction);
  };
  return (
    <div className="official">
      <div className="official-post">
        <div className="official__img" />
        <div className="official-info">
          <div className="official-info-top">
            <span className="official-title">{currentPost.title}</span>
            <Tags tags="CSS, HTML" />
          </div>
          <div className="official-info-middle">
            <span>{currentPost.desc}</span>
          </div>
          <div className="official-info-bottom">
            <div className="official-info-bottom-left">
              <img
                src={noImg}
                alt="no-img"
                className="official-info-bottom-left__img"
              />
              <span className="official-info-bottom-left__span">
                {currentPost.author}
              </span>
            </div>
            <PostDetails
              date="2022.05.04"
              views={currentPost.looked}
              hearts={currentPost.liked}
            />
          </div>
        </div>
      </div>
      <div className="official-bottom">
        {result.map((post, index) => (
          <button
            key={post.pid}
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
