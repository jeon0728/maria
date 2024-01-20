package com.example.maria.service

import com.example.maria.Entity.PostEntity
import com.example.maria.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostService(private val repository: PostRepository) {

    fun getAllPosts() : List<PostEntity> = repository.findAll()
    // PostRepository 의 findAll이라는 함수의 실행 값을 가지는 함수 getAllPosts
    // 리턴값으로 PostEntity 의 리스트를 받는다.

    fun createPost(name: String, age: Int) : PostEntity{
        val post = PostEntity(name = name, age = age)
        return repository.save(post)
    }
    // 엔티티 생성 함수 createPost
    // PostEntity 에 이름과 나이 값을 넣어 엔티티 생성 (id는 자동증분이기 때문에 인자로 넘기지 않고, name, age만 지정해서 넘겨줌)
    // save 함수를 통해 db에 insert

    fun getPostById(id:Long) : PostEntity? {
        return repository.findByIdOrNull(id)
    }
    // id를 통하여 데이터를 가져오는 함수 getPostById
    // findByIdOrNull 이름에서 알 수 있듯이 null도 반환한다.
    // 그렇기 때문에 리턴타입인 PostEntity에 '?' 가 붙어있는것을 볼 수 있다.

    fun updatePost(id: Long, name: String, age: Int) : PostEntity? {
        val exist = repository.findByIdOrNull(id)
        exist?.let {
            return repository.save(PostEntity(name = name, age = age))
        }
        return null
    }
    // id를 통하여 원하는 데이터를 찾고 해당 데이터를 수정하는 함수 updatePost
    // findByIdOrNull 의 리턴값이 null 도 포함이기에 null 일 경우 let 함수를 타지 않음 '?.'
    // null 이 아니라면 let 함수 블록 안에 있는 save 함수가 호출
    // let 함수 : 인스턴스의 값을 람다함수를 사용해 변경
    // let 함수가 실행 된다면 블럭 안에 있는 save 함수가 실행되고 해당 인스턴스에 리턴되어 값이 변경되게 된다.

    fun deletePost(id: Long) = if (repository.findByIdOrNull(id) != null) {
        repository.deleteById(id)
        true
    } else {
        false
    }
    // id를 통하여 원하는 데이터를 삭제하는 함수 deletePost
    // if문을 통하여 null 이 아닌경우 삭제
}